#include <stdio.h>
#include <string.h>
//マクロ宣言
#include <limits.h>

//Boyer-Moore法の関数定義
//文字列のポインタは配列表現でポインタ
int bm_match(const char txt[],const char pat[])
{
  printf("%c %c",pat[0],pat[1]);
  int pt = 0;
  int pp = 0;
  //テキストの文字列
  int txt_len = strlen(txt);
  //パターンの文字列
  int pat_len = strlen(pat);
  //スキップ表の文字列
  int skip[UCHAR_MAX + 1];

  for (pt = 0 ; pt <= UCHAR_MAX; pt++ ){
    skip[pt] = pat_len;
  }
  for (pt = 0 ; pt <= pat_len - 1; pt++ ){
    skip[pat[pt]] = pat_len - pt - 1;
  }

  while (pt < pat_len){
    pp = pat_len　-1 ;
    while(txt[pt] == pat[pp]){
      if(pp == 0)
        return 0;
      pp--;
      pp++;
    }
    pt += (skip[txt[pt]] > pat_len -pp) ? skip[txt[pp]] : pat_len - pp;
  } 
}

int main(void)
{
  int idx;
  char s1[256]; //テキスト
  char s2[256]; //パターン

  puts("Boyer-Moore法");
  printf("テキスト　：");
  scanf("%s", s1);

  printf("パターン　：");
  scanf("%s", s2);

  idx = bm_match(s1,s2);
  if(idx == -1)
    puts("テキスト中にパターンは存在しません");
  else
    printf("%d文字目にマッチします",idx + 1);
  return 0;
}
