package com.vmware.nativeconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication(proxyBeanMethods = false)
public class NativeConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeConfigServerApplication.class, args);
    }

//	@RestController
//	class MessageRestController {
//
//		@Value("${message:Hello default}")
//		private String message;
//
//		@GetMapping("/greeting")
//		String getMessage() {
//			return this.message;
//		}
//	}

}
