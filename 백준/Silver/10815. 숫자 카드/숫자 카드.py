import sys
input = sys.stdin.readline

n = int(input())
cards =dict.fromkeys((map(int, input().split())), 1)
m = int(input())
check_cards=dict.fromkeys((map(int, input().split())), 0)
for card in check_cards.keys():
    if card in cards.keys():
        check_cards[card]=1

for elem in check_cards.values():
    print(elem, end=' ')