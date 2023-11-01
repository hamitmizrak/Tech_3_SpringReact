# docker image build -t imageAdi .
# docker container run -d -p 4444:4444 --rm --name my_imageName

# DockerHub push
#1.adım: Dockerfile ile image oluştur
#2.adım: Dockerhub üzerinden repository oluştur
#3.adım:  docker ps
#image name: image_spring_react

#4.adım: docker image tag image_spring_react javahamitmizrak/fullstack11
#5.adım: docker push javahamitmizrak/fullstack11

# JDK Sürümü
FROM openjdk:21

# Bilgilendirme
LABEL maintainer="hamitmizrak@gmail.com"

# Çevresel Değişkenler
ENV APP_NAME="Full Stack 11"
ENV VERSION="v1.0.0"
ENV PORT="4444"

# Çıktı almak
## RUN apt-get update && apt-get upgrade -y && apt-get dist-upgrade -y
RUN echo   "App name: $APP_NAME"
RUN echo   "Version : $VERSION"
RUN echo   "Port: $PORT"

# Dizin oluştur
# WORKDIR /var/www/html

# Localdeki dosyaları image dosyalardaki yere kopyala
# COPY . /var/www/html

# Kalıcılık
VOLUME /tmp

# Port
EXPOSE 4444

# Projeki jar dosyasının yerini bulmak
ARG JAR_FILE=/target/*.jar

# Proje isimlendirmesini kısaltmak
ADD ${JAR_FILE} spring_react

# Container çalışıyor mu çalışmıyor mu
# --interval=30s  ==> Sağlık kontrolunde her 30 saniyede bir kontrol yapmak
# --timeout=3s    ==> Kontrol komutun maksimum çalışma süresini gösterir.
# Eğer bu 3s komutu belirtilenin dışına çıkarsa Docker sağlıksız olarak işaretlenir
# CMD wget --quiet --tries=1 --spider http://localhost : wget ile localhost istek atmak
HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget --quiet --tries=1 --spider http://localhost:4444 || exit 1

# Docker konteynarı çalışması sırasında varsılan çalışacak komutlar
# Uygulamayı başlatma komut dizinidir
# ENTRYPOINT ["executable","param1","param2","param3"]
ENTRYPOINT ["java","-jar","/spring_react"]

# Container çalışırken istediğimiz script
# CMD []