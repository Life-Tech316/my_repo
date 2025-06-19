#STEP:1 Ubuntuベースイメージ
FROM ubuntu:16.04

# Nginxのインストール
RUN apt-get -y update && apt-get -y upgrade
RUN apt-get -y install nginx

#ポート番号指定
EXPOSE 80

CMD ["nginx","-g,"daemon off;"]
