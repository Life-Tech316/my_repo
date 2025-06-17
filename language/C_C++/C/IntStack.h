//_ヘッダファイル名_H_を記載
//

#ifndef _IntStack_H_
#define _IntStack_H_

//スタックを実現する構造体
//stkを格納するスタック本体用の配列
//スタックの容量（stkの要素数と一致）
//ptr（スタックポインタ）
typedef struct{
	int	max;
	int ptr;
	int *stk;
} IntStack;

//スタックの初期化
int Initialize(IntStack *s,int max);

int Push(IntStack *s, int x);

int Pop(IntStack *s, int *x);

int Peek(const IntStack *s, int *x);

void Clear(IntStack *s);

int Capacity(const IntStack *s);

int Size(const IntStack *s);

int IsEmpty(const IntStack *s);

int IsFull(const IntStack *s);

int Search(const IntStack *s,int x);

void Print(const IntStack *s);

void Terminate(IntStack *s);

#endif
