use strict;
use warnings;

open(FILE,'file.html') or die "$1";
my @file = <FILE>;
close(FILE);
foreach my $line (@file){
  $line =~ s/モチベーション/モチベーション(動機)/g;
}
open(NEWFILE,'> file.html') or die "$!";
print NEWFILE @file;
close(NEWFILE);
