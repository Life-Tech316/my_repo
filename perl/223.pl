my $str = "The price is 300yen. The distance is 120km \n";
$str =~ s/((\d+)([A-Za-z]+))/$2<$3>/g;
print $str;

my $str = "Hy, I'm nishizuka takuma, nice to meet you";
$str =~ s/\w+/ucfirst($&)/ge;
$str =~ s/$/\n/;
print $str;
