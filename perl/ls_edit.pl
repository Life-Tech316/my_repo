use strict;
use warnings;

#引数からの読み込み
my $file = shift;

open my $fh, '<',$file;

#配列の定義
my $cpu_infos=[];

while (my$line =<$fh>){

	#1行目を飛ばす
	next if $. == 1;
	chomp $line;

	my @rec = split /\s+/, $line;
	my $cpu_info={};
	$cpu_info->{auth} = $rec[0];
	$cpu_info->{time} = join(',',$rec[5],$rec[6],$rec[7]);
	#$cpu_info->{time} = $rec[7];
	$cpu_info->{name} = $rec[8];

	push @$cpu_infos,$cpu_info;
}

close $fh;

my @headers =qw/auth %time %name/;

print join(',',@headers) . "\n";

foreach my $cpu_info (@$cpu_infos){
	my @rec = (
		$cpu_info->{auth},
		$cpu_info->{time},
		$cpu_info->{name}
	);
	print join(',',@rec) . "\n";
}
