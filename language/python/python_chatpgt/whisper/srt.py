import openai

file = open("sample.mp3","rb")

transcript = openai.Audio.transcribe(
    model="whisper-1",
    file=file,
)

print(transcript.text)
