# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n = int(input())

moum = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
li = []

for i in range(n):
	s = input()
	if s == '':
		print('???')
		li = []
		continue
	for j in s:
		if j in moum:
			li.append(j)
	if len(li) == 0:
		print('???')
		li = []
		continue
	print(''.join(li))
	li = []