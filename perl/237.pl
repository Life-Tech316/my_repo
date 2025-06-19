#tr///cs csの使用例　：連続スペースとそれ以外の意味
my $str = 'Yahoo!JAPAN & Yahoo! (USA)';
$str =~ tr/A-Za-z0-9/ /cs;
print "|$str|\n";

my $str = 'The distance is 303.56km';

$str =~ /[+-]?\d+\.?\d+/;
print "$&\n";
