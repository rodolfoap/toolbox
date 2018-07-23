public class Phrase:Object{
	string text;
	public Phrase(){
		stdout.printf("Phrase: ");
		this.text=stdin.read_line();
	}
	public void pRevert() {
		this.text=this.text.reverse();
	}
	public static void main(){
		Phrase phrase;
		phrase=new Phrase();
		stdout.printf("String: %s\n", phrase.text);
		phrase.pRevert();
		stdout.printf("String: %s\n", phrase.text);
	}
}
