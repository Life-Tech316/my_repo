#厳しいプログラミングチェック
use strict;
#詳細な警告内容
use warnings;

#変数の初期化にはmyが必要
my $html1 = "<pre>Sunday</pre>";
my $html2 = "<pre>Sunday¥nMonday</pre>";
my $html3 = "<pre>Sunday</pre>and<pre>Sunday¥nMonday</pre>";
#my $html4 = "<pre>Sunday</pre>";

my $data1 = &extract_pre($html1);
my $data2 = &extract_pre($html2);
my $data3 = &extract_pre($html3);

print "$data1\n";
print "$data2\n";
print "$data3\n";
#print "¥$data2 = ¥"$data2¥"¥n";
#print "¥$data3 = ¥"$data3¥"¥n";

#関数の代わりにサブルーチン
sub extract_pre {
#関数の最初には以下が必要=>変数の
my ($html) = @_;

my $data = ($html =~ m|<pre>(.*?)</pre>|gis);
my $line = join(',',$data);
$line =~ s/\n/,/gs;
return $line;
}
