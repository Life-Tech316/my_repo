use strict;
use warnings;

my @rhymes = ("Humpty Dumpty sat on a Wall,",
"Humpty Dumpty had a great fall;",
"All the King's horse, and all the King's men",
"Cannot put HUm pty Dumpty together again.",
);


#print $rhymes[0];
my $i1 = 0;
#カウント用の変数
my $i = 0;
#ハッシュ変数の定義
my %count;

#配列の要素を取り出し
foreach my $line (@rhymes){
  #$lineを小文字にし、splitで分割して配列として@wordに代入
  my @word  = split(/[^\w']+/,lc($line));
  #配列を一個ずつ$wordを取り出す
    foreach my $word (@word){
      #ハッシュのスカラー変数($word)というキーに対応する「数字」を++
      $count{$word}++;
    }gt
}

foreach my $key (sort keys %count) {
  print "$key $count{$key}\n";
}
