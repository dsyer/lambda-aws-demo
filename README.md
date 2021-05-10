# spring-native-demo

This is a copy of this example https://github.com/dsyer/spring-native/tree/foo/spring-graal-native-samples/function-aws.

AWS Lambda custom runtime.

```
$ ./mvnw package -P native-image
```

builds a native-zip ZIP file in target. Upload it to AWS and set the handler to "fooFunction".
