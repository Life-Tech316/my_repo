use strict;
use warnings;

open(FILE, 'web.html') or die "$!";
open(NEWFILE, '> file.html') or die "$!";

while (my $line = <FILE>){
  $line =~ s/動機/モチベーション/g;
  print NEWFILE $line;
}
close(NEWFILE);
close(FILE);
