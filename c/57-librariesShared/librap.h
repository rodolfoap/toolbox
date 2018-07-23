#ifndef foo_h__
#define foo_h__

extern void foo(void);

#endif

#ifndef LOG
#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);
#endif
