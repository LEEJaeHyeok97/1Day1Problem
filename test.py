import math

import numpy as np
import numpy as numpy
import torch

dtype = torch.float
device = "cuda" if torch.cuda.is_available() else "cpu"
torch.set_default_device(device)

#
#
# d = 0.1
# x = []
#
# _x = -math.pi
# while _x <= math.pi:
#     x.append(_x)
#     _x += d
#
# y = []
# for _x in x:
#     y.append(math.sin(_x))



print(x)
# raise Exception('debug')

a = torch.randn((), dtype=dtype, requires_grad=True)
b = torch.randn((), dtype=dtype, requires_grad=True)
c = torch.randn((), dtype=dtype, requires_grad=True)
d = torch.randn((), dtype=dtype, requires_grad=True)


x = np.linspace(-math.pi, math.pi, 2000)
print(f'{x.shape = }')
print(f'{x = }')
print(f'x.shape = {x.shape}')
print(f'{x = }')

y = np.sin(x)

print(f'{y.shape = }')
print(f'{y = }')

def compute_y_pred(x_):
    return a + b * x_ + c * x_ ** 2 + d * x_ ** 3

def compute_loss(y_, y_pred_):
    return ((y_pred_ -y_) **2).mean()


learning_rate = 1e-3
for t in range(4000):
    y_pred = compute_y_pred(x)
    loss = compute_loss(y, y_pred)
    if (t + 1) % 200 == 0:
        print(t + 1, loss.item())
    loss.backward()

    with torch.no_grad():
        a -= learning_rate * a.grad
        b -= learning_rate * b.grad
        c -= learning_rate * c.grad
        d -= learning_rate * d.grad

    a.grad = None
    b.grad = None
    c.grad = None
    d.grad = None

# 19장 까지 코딩 직접해서 11시까지 제출하기