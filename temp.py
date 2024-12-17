s = str(input())

arrs = s.split(':')
secondList = [arrs.pop(i) for i in range(len(arrs) - 1, -1, -1) if arrs[i].endswith('a')]
print(secondList)