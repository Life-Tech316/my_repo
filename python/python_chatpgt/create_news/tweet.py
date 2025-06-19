import gpt_api
import tweet_api

#chatgptからツイート内容を取得
tweet = gpt_api.make_tweet()
    
#twitterにツイートを投稿
tweet_api.post(tweet)
