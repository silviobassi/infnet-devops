import http from 'k6/http';
import {check} from 'k6';

export let options = {
    scenarios: {
        fase1: {
            executor: 'per-vu-iterations',
            vus: 100,
            iterations: 2,
            startTime: '0s',
            maxDuration: '2m',
        },
        fase2: {
            executor: 'per-vu-iterations',
            vus: 500,
            iterations: 2,
            startTime: '2m',
            maxDuration: '3m',
        },
        fase3: {
            executor: 'per-vu-iterations',
            vus: 1000,
            iterations: 2,
            startTime: '5m',
            maxDuration: '2m',
        },
        fase4: {
            executor: 'per-vu-iterations',
            vus: 500,
            iterations: 2,
            startTime: '7m',
            maxDuration: '2m',
        },
        fase5: {
            executor: 'per-vu-iterations',
            vus: 100,
            iterations: 2,
            startTime: '9m',
            maxDuration: '2m',
        },
        faseFinal: {
            executor: 'per-vu-iterations',
            vus: 1,
            iterations: 2,
            startTime: '11m',
            maxDuration: '1m',
        },
    },
};

export default function () {
    let res = http.get('http://127.0.0.1:32797/matriculas/2/buscar');

    check(res, {
        'status é 200': (r) => r.status === 200,
        'tempo < 500ms': (r) => r.timings.duration < 500,
    });
}
