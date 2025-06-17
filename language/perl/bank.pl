use strict;
use warnings;

print "暗証番号を入力してください\n";

my $line;

do{
 my $line = <STDIN>;
 chomp($line);
}until ( $line = /^\d+$/); 

if ($line eq "0314"){
    print "金庫が空きました、\n";
} else {
    print "暗証番号が違います\n"; 
 
}


