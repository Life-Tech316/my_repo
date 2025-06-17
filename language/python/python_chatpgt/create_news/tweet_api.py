#ライブラリopenaiをよみこみ
import tweepy
import os

consumerKey = os.environ["TWITTER_CONSUMER_KEY"] #za3UXjayyIwDPFDIzjWyO6r1t
consumerSecret = os.environ["TWITTER_CONSUMER_SECRET"] #12lNeqUaNFtuiG5ZkazJkIzCrEuNN1v4Y3dBnwibATTDT4MxK5
accessToken = os.environ["TWITTER_ACCESS_TOKEN"] #1289987478-KsZC75hR39F87CH1DNkuXRATxVolO8l27HzaYbK
accessTokenSecret = os.environ["TWITTER_ACCESS_TOKEN_SECRET"] #Bh3cEvY2rM8KklYTqa4nQTtaCUZqeZFkkT6qgV19H1rvN
bearerToken = os.environ["TWITTER_BEARER_TOKEN"] #AAAAAAAAAAAAAAAAAAAAAB9XuwEAAAAAk1qHiTFo%2FHqExfsmL7iG0ALQw7A%3DRy3YzmN7jriRqRMGO9GfMrorfjZ4UdvdeFbenK402StX51LvFv


def post(tweet):
    #tweetpy　クライアント作成
    client = tweepy.Client(
        bearerToken,
        consumerKey,
        consumerSecret,
        accessToken,
        accessTokenSecret
    )

    #ポストを投稿
    client.create_tweet(text=tweet)
