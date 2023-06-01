import numpy as np


class Perceptron:
    def __init__(self, learning_rate=0.1, num_iterations=100):
        self.learning_rate = learning_rate
        self.num_iterations = num_iterations

    def train(self, X, y):
        # Agregar una columna de unos a los datos de entrada para el término de sesgo
        X = np.c_[np.ones((X.shape[0], 1)), X]
        self.weights = np.zeros(X.shape[1])  # Inicializar los pesos a cero

        for _ in range(self.num_iterations):
            for i in range(X.shape[0]):
                activation = np.dot(X[i], self.weights)
                prediction = self.predict(X[i])
                error = y[i] - prediction
                self.weights += self.learning_rate * error * X[i]

    def predict(self, X):
        # Agregar una columna de unos a los datos de entrada para el término de sesgo
        X = np.insert(X, 0, 1)
        activation = np.dot(X, self.weights)
        return 1 if activation >= 0 else 0


# Datos de entrenamiento
X = np.array([[2, 3], [1, 5], [4, 2], [6, 1]])
y = np.array([0, 0, 1, 1])

# Verificar las dimensiones de los datos
assert X.shape[0] == y.shape[0], "El número de muestras en X y y no coincide."

# Verificar la forma de los datos de entrada
assert X.ndim == 2, "X debe ser una matriz de 2 dimensiones."
assert y.ndim == 1, "y debe ser un vector de 1 dimensión."

# Crear y entrenar el perceptrón
perceptron = Perceptron()
perceptron.train(X, y)

# Nuevos datos para realizar predicciones
new_data = np.array([[3, 4], [5, 2]])

# Hacer predicciones en los nuevos datos
for data in new_data:
    prediction = perceptron.predict(data)
    print(f"Input: {data}, Prediction: {prediction}")
