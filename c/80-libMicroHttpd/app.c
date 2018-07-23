#include <microhttpd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);
#define PAGE "<html><head><title>libmicrohttpd demo</title></head><body><h1>Hello, World!</h1></body></html>"

static int ahc_echo(void *cls, struct MHD_Connection *connection,
			const char *url,
			const char *method,
			const char *version,
			const char *upload_data, size_t * upload_data_size, void **ptr) {
	LOG
	printf("URL=%s\n", url);
	printf("METHOD=%s\n", method);
	printf("VERSION=%s\n", version);
	printf("DATA=%s\n", upload_data);
	printf("SIZE=%i\n", upload_data_size);
	static int dummy;
	const char *page = cls;
	struct MHD_Response *response;
	int ret;

	if(0 != strcmp(method, "GET")) return MHD_NO; // unexpected method
	if(&dummy != *ptr) { // The first time only the headers are valid, do not respond in the first round...
		*ptr = &dummy;
		return MHD_YES;
	}
	if (0!=*upload_data_size) return MHD_NO; // upload data in a GET?
	*ptr=NULL; // clear context pointer
	response=MHD_create_response_from_buffer(strlen(page), (void *)page, MHD_RESPMEM_PERSISTENT);
	ret=MHD_queue_response(connection, MHD_HTTP_OK, response);
	MHD_destroy_response(response);
	return ret;
}

int main(int argc, char **argv) {
	struct MHD_Daemon *daemon;
	if (argc != 2){printf("%s [PORT]\n", argv[0]); return 1;}
	daemon = MHD_start_daemon(MHD_USE_THREAD_PER_CONNECTION, atoi(argv[1]), NULL, NULL, &ahc_echo, PAGE, MHD_OPTION_END);
	if (daemon == NULL) return 1;
	(void)getc(stdin);
	MHD_stop_daemon(daemon);
	return 0;
}
