from flask import Flask, request, jsonify

app = Flask(__name__)

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

    return contagem


@app.route('/contagem', methods=['POST'])
def obter_contagem():
    dados = request.json
    if 'lista' in dados:
        lista = dados['lista']
        resultado = contar_elementos(lista)
        return jsonify(resultado)
    else:
        return jsonify({'error': 'A lista de inteiros entre 0 e 15 não foi fornecida.'}), 400


if __name__ == '__main__':
    app.run(debug=True)
