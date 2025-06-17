use strict;

use warnings;


#openでファイルのオープン
#FILEはファイルハンドルと呼ばれるもので、ファイル操作は
#これを通じて行われる。
open(FILE,'file.html') or die "$!";
#書き込みモードでファイルをオープン
open(NEWFILE, '>new.html') or die "$!";

my $cnt = 0;

#<FILE>で一行ずつ読み込み
#<FILE>を通じて1行ずつ読み込み
while (my $line = <FILE>){
if ( $cnt == 0){
    print NEWFILE "本文始まり";
}
    $cnt++;
　　#読み込んだ行の処理
    print NEWFILE $line;
}
#ファイルのclose処理
close(NEWFILE);
close(FILE);
