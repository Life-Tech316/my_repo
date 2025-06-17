#文字列の定義
my $str = 'The price is 300yen';
#変数定義
my $number;
#変数定義
my $price;
#strから数字列と一致するかを判断
if($str =~ /\d+/){
  #一致したもの変数に代入
  $number = $&;
  print "$number is the numer.\n";
}
#正規表現と一致するかを判断
if ($str =~ /\d+[A-Za-z]+/){
  $price = $&;
  print "$price is th price,\n";
}
print "¥$number = $number\n";
print "¥$number = $number\n";
