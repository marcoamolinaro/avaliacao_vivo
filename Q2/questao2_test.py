import unittest
import json
from questao2 import app

class TestAPI(unittest.TestCase):
    
    def setUp(self):
        self.app = app.test_client()

    def test_contagem(self):
        lista_valida = [1, 3, 5, 7, 9, 11, 13, 15]
        lista_invalida = [17, 18, 20]

        # Teste com uma lista válida
        response = self.app.post('/contagem', json={'lista': lista_valida})
        data = json.loads(response.data.decode('utf-8'))
        self.assertEqual(response.status_code, 200)
        self.assertIn('1', data)
        self.assertIn('3', data)
        self.assertIn('5', data)
        self.assertIn('7', data)
        self.assertIn('9', data)
        self.assertIn('11', data)
        self.assertIn('13', data)
        self.assertIn('15', data)

        # Teste com uma lista inválida
        response = self.app.post('/contagem', json={'lista': lista_invalida})
        data = json.loads(response.data.decode('utf-8'))
        self.assertEqual(response.status_code, 200)
        self.assertEqual(data, {})

    def test_contagem_sem_lista(self):
        response = self.app.post('/contagem', json={})
        data = json.loads(response.data.decode('utf-8'))
        self.assertEqual(response.status_code, 400)
        self.assertIn('error', data)

if __name__ == '__main__':
    unittest.main()
