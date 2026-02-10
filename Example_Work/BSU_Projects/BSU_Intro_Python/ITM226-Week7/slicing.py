text = "Hello, World !"

slice1 = text[0:5]
print(slice1)
slice2 = text[7:]
print(slice2)
slice3 = text[:5]
print(slice3)
slice4 = text[-6:-1]
print(slice4)
slice5 = text[:]
print(slice5)

print()
print()

text = "abcdefg"

slice1 = text[::2]
print(slice1)
slice2 = text[::-1]
print(slice2)
slice3 = text[1:6:2]
print(slice3)
slice4 = text[5:1:-1]
print(slice4)

print()
print()

text = "ITM226 is fun"
words = text.split()
print(words)

print()

sentence = " ".join(words)
print(sentence)