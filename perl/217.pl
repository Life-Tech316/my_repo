use strict;
use warnings;

my $str = <STDIN>;
if ( !($str =~ /^[\d][\d][\d]\.[\d][\d][\d]\.[\d][\d][\d]\.[\d][\d][\d]$/)){

  print "入力値エラー";
}

if ($str =~ /(\d+).(\d+).(\d+).(\d+)/){
  my $first = $1;
  my $second = $2;
  my $third = $3;

  print "\$first = $first\n";
  print "\$second = $second\n";
  print "\$third = $third\n";
}
