use strict;
use warnings;

while (my $str = <STDIN>){
  chomp($str);
  last if ($str eq 'end' ); #if文の条件式
  if ($str =~ /^yes/){
    print "Match\n";
  } else {
    print "No match\n";
  }
}
