feign的使用：
首先导入依赖
在主程序上声明@EnableFeignClients

然后定义一个接口，在接口上@FeignClient(value = "service-hi")，表明使用哪个服务

定义一个方法，方法上的注解表明调用该方法将调用服务的这个方法@GetMapping(value = "/hi/{name}")