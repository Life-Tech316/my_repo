use strict;
use warnings;

while (my $str = <STDIN>){
  chomp($str); #改行の削除
  last if ($str eq 'end');
  if ($str =~ /^(takuma)?abc/){
    print "$& --- Match\n";
  } else {
    print "No match\n";
  }
}




