# COMMANDLINEFU.COM

Given that COMMANDLINEFU.COM interface has completely degraded, here are some commands that I use ocasionally. 

See https://web.archive.org/web/20150512005555/http://www.commandlinefu.com/commands/by/rodolfoap.

## Encrypt and password-protect execution of any bash script

`script.bash` is your script, which will be encrypted to `script.secure`: `script.bash` --> `script.secure`
You can execute `script.secure` only if you know the password. If you die, your script dies with you.
If you modify the startup line, be careful with the offset calculation of the crypted block (the XX string).
Not difficult to make script editable (an offset-dd piped to a gpg -d piped to a vim - piped to a gpg -c directed to script.new ), but not enough space to do it on a one liner.

```
echo "eval \"\$(dd if=\$0 bs=1 skip=XX 2>/dev/null|gpg -d 2>/dev/null)\"; exit" > script.secure; sed -i s:XX:$(stat -c%s script.secure): script.secure; gpg -c < script.bash >> script.secure; chmod +x script.secure
```

#### Sample Output
```
$ cat script.bash

#!/bin/bash
echo "Hello, world"

$ echo "eval \"\$(dd if=\$0 bs=1 skip=XX 2>/dev/null|gpg -d 2>/dev/null)\"; exit" > script.secure; sed -i s:XX:$(stat -c%s script.secure): script.secure; gpg -c < script.bash >> script.secure; chmod +x script.secure
Enter passphrase:
Repeat passphrase:

$ ./script.secure
Enter passphrase:

Hello, world

$ cat script.secure
eval "$(dd if=$0 bs=1 skip=69 2>/dev/null|gpg -d 2>/dev/null)"; exit
%6&A2%&F%&B%&%4&%
```
## Encrypt and password-protect execution of any bash script, Version 2

Use any script name (the read command gets it) and it will be encrypted with the extension .crypt, i.e.: `myscript` --> `myscript.crypt`
You can execute myscript.crypt only if you know the password. If you die, your script dies with you.
If you modify the startup line, be careful with the offset calculation of the crypted block (the XX string).
Not difficult to make script editable (an offset-dd piped to a gpg -d piped to a vim - piped to a gpg -c directed to script.new ), but not enough space to do it on a one liner.
Sorry for the chmod on parentheses, I dont like "-" at the end.
Thanks flatcap for the subshell abbreviation to /dev/null

```
read -p 'Script: ' S && C=$S.crypt H='eval "$((dd if=$0 bs=1 skip=//|gpg -d)2>/dev/null)"; exit;' && gpg -c<$S|cat >$C <(echo $H|sed s://:$(echo "$H"|wc -c):) - <(chmod +x $C)
```
#### Sample Output
```
$ cat script.bash

#!/bin/bash
echo "hello, world"

$ read -p 'Script: ' S && C=$S.crypt H='eval "$(dd if=$0 bs=1 skip=// 2>/dev/null|gpg -d 2>/dev/null)"; exit;' && gpg -c<$S|cat >$C <(echo $H|sed s://:$(echo "$H"|wc -c):) - <(chmod +x $C)

Script: script.bash
Enter passphrase:
Repeat passphrase:

$ cat script.bash.crypt

eval "$(dd if=$0 bs=1 skip=70 2>/dev/null|gpg -d 2>/dev/null)"; exit;
%3@5%7%f$2&s*ty7%8@j$j!8)(&@@@

$ ./script.bash.crypt
Enter passphrase:

hello, world
```
##  Create executable, automountable filesystem in a file, with password!

This is just a proof of concept: A FILE WHICH CAN AUTOMOUNT ITSELF through a SIMPLY ENCODED script. It takes advantage of the OFFSET option of mount, and uses it as a password (see that 9191? just change it to something similar, around 9k). It works fine, mounts, gets modified, updated, and can be moved by just copying it.

#### Usage

The file is composed of three parts:

a) The legible script (about 242 bytes)

b) A random text fill to reach the OFFSET size (equals PASSWORD minus 242)

c) The actual filesystem

Logically, (a)+(b) = PASSWORD, that means OFFSET, and mount uses such option.

**PLEASE NOTE: THIS IS NOT AN ENCRYPTED FILESYSTEM**. To improve it, it can be mounted with a better encryption script and used with encfs or cryptfs. The idea was just to test the concept... with one line :)

It applies the original idea of http://www.commandlinefu.com/commands/view/7382/command-for-john-cons for encrypting the file.

The embedded bash script can be grown, of course, and the offset recalculation goes fine. I have my own version with bash --init-file to startup a bashrc with a well-defined environment, aliases, variables.

```
dd if=/dev/zero of=T bs=1024 count=10240;mkfs.ext3 -q T;E=$(echo 'read O;mount -o loop,offset=$O F /mnt;'|base64|tr -d '\n');echo "E=\$(echo $E|base64 -d);eval \$E;exit;">F;cat <(dd if=/dev/zero bs=$(echo 9191-$(stat -c%s F)|bc) count=1) <(cat T;rm T)>>F
```
#### Sample Output
```
Use at your own risk.

# dd if=/dev/zero of=T bs=1024 count=10240;mkfs.ext3 -q T;E=$(echo 'read O;mount -o loop,offset=$O F /mnt;'|base64|tr -d '\n'); echo "E=\$(echo $E|base64 -d);eval \$E;exit;">F;cat <(dd if=/dev/zero bs=$(echo 9191-$(stat -c%s F)|bc) count=1) <(cat T;rm T)>>F
10240+0 records in
10240+0 records out
10485760 bytes (10 MB) copied, 0.127043 s, 82.5 MB/s
T is not a block special device.
Proceed anyway? (y,n) y
1+0 records in
1+0 records out
9104 bytes (9.1 kB) copied, 0.000116352 s, 78.2 MB/s

(before executing next, make sure /mnt is empty and has nothing mounted, otherwise you can lose some files)

# bash F
9191
(I've entered 9191, is the password, can be modified in the script)

# l /mnt/
drwx------ 2 root root 12K Jan 31 02:33 lost+found/

# df -h
Filesystem        Size  Used Avail Use% Mounted on
...
/dev/loop0        9.7M  1.1M  8.1M  12% /mnt

# mount
...
/root/F on /mnt type ext3 (rw,relatime,data=ordered)

# umount /mnt

# head -1 F
E=$(echo cmVhZCBPO21vdW50IC1vIGxvb3Asb2Zmc2V0PSRPIEYgL21udDsK|base64 -d);eval $E;exit;

# E=$(echo cmVhZCBPO21vdW50IC1vIGxvb3Asb2Zmc2V0PSRPIEYgL21udDsK|base64 -d);echo $E
(changed eval x echo)
read O;mount -o loop,offset=$O F /mnt;
```

## Command For JOHN CONS

Would create a file with a meaningful title. Dedicated to John Cons, who is annoying us users [in the CommandLineFu.com website]. Merry Christmas!!!

```
alias Z=base64&&Z=dG91Y2ggUExFQVNFX1NUT1BfQU5OT1lJTkdfQ09NTUFORExJTkVGVV9VU0VSUwo=&&$(echo $Z|Z -d)
```
#### Sample Output
```
ls
```

## Numbers Guessing Game

Felt like I need to win the lottery, and wrote this command so I train and develop my guessing abilities.

```
A=1;B=100;X=0;C=0;N=$[$RANDOM%$B+1];until [ $X -eq $N ];do read -p "N between $A and $B. Guess? " X;C=$(($C+1));A=$(($X<$N?$X:$A));B=$(($X>$N?$X:$B));done;echo "Took you $C tries, Einstein";
```
#### Sample Output
```
N between 1 and 100. Guess? 50
N between 1 and 50. Guess? 20
N between 20 and 50. Guess? 21
Took you 3 tries, Einstein
```
