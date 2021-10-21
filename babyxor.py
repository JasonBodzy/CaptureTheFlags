import random

flag = b"flag{REDACTED}"
key = bytearray()
for i in range(5):
    key.append(random.randrange(0, 256))

enc = bytearray()
for i in range(len(flag)):
    enc.append(flag[i] ^ key[i % 5])



def xorByRandom(inputBytes):
  randKey = bytearray()
  for i in range(5):
    randKey.append(random.randrange(0, 256))
  dec = bytearray()
  for i in range(len(inputBytes)):
    dec.append(inputBytes[i] ^ randKey[i % 5])
  return dec

def generateKey(inputBytes):
  generatedKey = bytearray()
  matched = False
  while(matched == False):
    keyCheck = random.randrange( 0, 256)
    if(chr(inputBytes[0] ^ keyCheck) == "f"):
      generatedKey.append(keyCheck)
      matched = True

  matched = False
  while(matched == False):
    keyCheck = random.randrange( 0, 256)
    if(chr(inputBytes[1] ^ keyCheck) == "l"):
      generatedKey.append(keyCheck)
      matched = True

  matched = False
  while(matched == False):
    keyCheck = random.randrange( 0, 256)
    if(chr(inputBytes[2] ^ keyCheck) == "a"):
      generatedKey.append(keyCheck)
      matched = True

  matched = False
  while(matched == False):
    keyCheck = random.randrange( 0, 256)
    if(chr(inputBytes[3] ^ keyCheck) == "g"):
      generatedKey.append(keyCheck)
      matched = True

  matched = False
  while(matched == False):
    keyCheck = random.randrange( 0, 256)
    if(chr(inputBytes[4] ^ keyCheck) == "{"):
      generatedKey.append(keyCheck)
      matched = True

  return generatedKey



enc2 = bytearray(b'i!\xc9B\x9a|9\x99I\x8dP\x03\x98Q\xben\x12\x98k\xd2P9\x99H\xa4P=\x9cA\x9c')

dec = bytearray()

for i in range(len(enc2)):
    dec.append(enc2[i] ^ generateKey(enc2)[i % 5])


for b in dec:
  print(chr(b), end="")
