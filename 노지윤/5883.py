#5883
import collections

num = int(input("How many? > "))
if(num<1 and num>1000) :
    print('num is over')
    num = int(input("How many? > "))

num_list = [input() for _ in range(num)]
num_list.sort()

counter = collections.Counter(num_list)
print(counter.most_common(1))

#####fail####
# count = {}
# for i in num_list :
#     try: count[i] += 1
#     except: count[i] = 1
# print(count)

# j = 0
# max = 0
# while j < len(count) :
#     print(count[j])
#     if (max < count[j]) :
#         max = count[j]
#         j = j+1
#
# print(max)
