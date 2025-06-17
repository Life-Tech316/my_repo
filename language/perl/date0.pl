use strict;
use warnings;

open(FILE, 'TOEIC.csv') or die "$!";
while (my $line = <FILE>){
  my ($name,@score) = split(/,/,$line);
  my $sum = 0;
  foreach my $score (@score){
    $sum += $score;
  }
  print $name, "\t",$sum, "\n";
}
close(FILE);
