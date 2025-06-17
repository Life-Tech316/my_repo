use strict;
use warnings;

open(FILE, 'TOEIC.csv') or die "$!";
my @file = <FILE>;
close(FILE);

foreach my $line (sort @file){
  my ($name,@score) = split(/,/,$line);
  my $sum = 0;
  foreach my $score (@score){
    $sum += $score;
  }
  print $name, "\t",sprintf("%3d",$sum), "\n";
}
