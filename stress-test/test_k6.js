import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '2m', target: 100 },   // Sobe para 100 usuários em 2 minutos
        { duration: '3m', target: 500 },   // Sobe até 500 usuários em 3 minutos
        { duration: '2m', target: 1000 },  // Sobe até 1000 usuários no pico em 2 minutos
        { duration: '2m', target: 500 },   // Reduz para 500 usuários em 2 minutos
        { duration: '2m', target: 100 },   // Reduz para 100 usuários em 2 minutos
        { duration: '1m', target: 0 },     // Finaliza reduzindo até 0
    ],
};

export default function () {
    let res = http.get('http://127.0.0.1:39507/especializacoes/listar');

    check(res, {
        'status é 200': (r) => r.status === 200,
        'tempo < 500ms': (r) => r.timings.duration < 500,
    });

    sleep(1); // espera 1s entre as requisições
}
