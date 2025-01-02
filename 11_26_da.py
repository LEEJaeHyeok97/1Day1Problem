import torch.nn



class Polynomial3:
    pass


model = Polynomial3()

criterion = torch.nn.MSELoss(reduction='')

class MyDataset(torch.utils.data.Dataset):
    def __init__(self, xs, ys):
        self.xs = xs
        self.ys = ys

    def __len__(self):
        return len(self.xs)

    def __getitem__(self, i):
        return self.xs[i], self.ys[i]

dataset = MyDataset(x, y)
print(len(dataset))
print(dataset[0])


##########
from torch.utils.data import Dataset, DataLoader

batch_size = 200
data_loader = DataLoader(my_dataset, batch_size, shuffle=True)

for X, y in data_loader:
    print(f"{X.shape = }")
    print(f"{y.shape = }")
    break


