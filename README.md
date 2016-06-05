## How to use

[docker-selenium](https://github.com/elgalu/docker-selenium/blob/master/README.md)

```shell
docker run -d --name=grid -p 4444:24444 -p 5900:25900 \
  -v /dev/shm:/dev/shm -e VNC_PASSWORD=hola \
  -e SCREEN_WIDTH=1920 -e SCREEN_HEIGHT=1480 \
  elgalu/selenium

docker exec grid wait_all_done 10s
```

### vnc
open vnc://:hola@192.168.99.100:5900

### browser
open http://192.168.99.100:4444/grid/console

## javadoc
- [selenium](http://seleniumhq.github.io/selenium/docs/api/java/)
- [selenide](http://selenide.org/javadoc.html)

