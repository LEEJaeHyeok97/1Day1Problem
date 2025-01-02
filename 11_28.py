import torch
from torch import nn
from torch.utils.data import DataLoader

device = (
        "cuda"
        if torch.cuda.is_available()
        else "cpu"
)
print(f"Using {device} device")

class NeuralNetwork(nn.Module):
    def __init__(self):
        super().__init__()
        self.flatten = nn.Flatten()
        self.linear1 = nn.Linear(28*28, 512)
        self.relu1 = nn.ReLU()
        self.linear2 = nn.Linear(512, 512)
        self.relu2 = nn.ReLU()
        self.linear3 = nn.Linear(512, 10)

    def forward(self, x):
        x = self.flatten(x)
        x = self.relu1(self.linear1(x))
        x = self.relu2(self.linear2(x))
        return self.linear3(x)


model = NeuralNetwork().to(device)
print(model)
loss_fn = nn.CrossEntropyLoss()
optimizer = torch.optim.SGD(model.parameters(), lr=1e-3)

def train(dataloader, model, loss_fn, optimizer):
    model.train()
    for x, y in dataloader:
        y_pred = model(x)
        loss = loss_fn(y_pred, y)
        loss.backward()
        optimizer.step()

def test(dataloader, model, loss_fn):
    model.eval()
    loss_sum = 0
    with torch.no_grad():
        for x, y in dataloader:
            y_pred = model(x)
            loss = loss_fn(y_pred, y)
            loss_sum += loss
    print(loss_sum)
    return loss_sum

epochs = 5
for t in range(epochs):
    print(f"Epoch {t+1}\n---------------------------")
    train(train_dataloader, model, loss_fn, optimizer)