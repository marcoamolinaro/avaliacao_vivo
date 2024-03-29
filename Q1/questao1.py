def contar_elementos(lista):
    matriz = [
        [5, 8, 3, 2, 1],
        [9, 7, 11, 0, 6],
        [4, 10, 13, 15, 12],
        [14, 3, 5, 8, 9],
        [1, 2, 6, 7, 4]
    ]

    contagem = {}
    for elemento in lista:
        if 0 <= elemento <= 15:
            contagem[elemento] = 0

    for linha in matriz:
        for valor in linha:
            if valor in contagem:
                contagem[valor] += 1

    resultado = ""
    for elemento, quantidade in contagem.items():
        resultado += f"O elemento {elemento} foi encontroado: {quantidade} veze(s)\n "

    return resultado[:-2]  # Remove a última vírgula e espaço


# Teste
entrada = [1, 3, 5, 7, 9, 11, 13, 15, 17]  # Exemplo de entrada
print(contar_elementos(entrada))
