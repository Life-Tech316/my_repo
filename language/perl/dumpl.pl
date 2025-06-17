use strict;
use warnings;

#引数の確認
if(@ARGV == 0){
  print "Usage: perl dumpl.pl filename\n";
  exit;
}

my $filename = shift @ARGV;

open (FILE, $filename) or die "$filename: $!";
#改行文字等の不具合遠なくすために、バイナリーモード
binmode(FILE);
my $count = 0;
#FILEから1文字ずつ受け取り、undefチェックをdefined関数で行うs
while (defined(my $char = getc(FILE))){
  printf("%08X : ", $count) if ($count % 16 == 0);
  printf("%02X : ", ord($char));
  printf("- ") if ($count % 16 == 7);
  printf("\n") if ($count % 16 == 15);
  $count++;
}
close(FILE);
