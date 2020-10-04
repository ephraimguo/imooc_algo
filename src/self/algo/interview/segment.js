const map = [
    "****",
    "*..*",
    "**.*",
    "****",
    "**.*",
    "**.*",
    "*.**",
    "****"
];

const cache = new Set();

const n = 4, m = 7;

let partNum = 0;

function connected(r, c) {

    function find(r, rem) {
        const size = rem.size;
        const chars = map[r];

        for (let i = 0; i < chars.length; i++) {
            const char = chars[i];
            if (char === ".") {
                let isLink = false;

                // left test
                if (i > 0) {
                    if (rem.has(r + "-" + (i - 1))) {
                        isLink = true;
                    }
                }

                // top test
                if (r > 0 && !isLink) {
                    isLink = rem.has(r - 1 + "-" + i);
                }

                // right test
                if (i < n - 1 && !isLink) {
                    isLink = rem.has(r + "-" + (i + 1));
                }

                if (isLink) {
                    rem.add(r + "-" + i);
                }
            }
            if (size !== rem.size && r < m - 1) {
                find(r + 1, rem);
            }
        }
    }

    const rem = new Set(); // cached set
    rem.add(r + "-" + c); // r-c
    c += 1;
    for (; c < m; c++) {
        const char = map[r][c];
        if (char === ".") {
            rem.add(r + "-" + c);
        }
    }

    if (r < m - 1) {
        find(r + 1, rem);
    }

    return rem;
}

// c is col
// r is row
for (let r = 0, c = 0; r < m && c < n; ) {
    if (!cache.has(r + "-" + c)) {
        const char = map[r][c];
        if (char === ".") {
            const set = connected(r, c);
            for (let k of set) {
                cache.add(k);
            }
            partNum += 1;
        }
    }

    if (c === n - 1) {
        c = 0;
        r += 1;
    } else {
        c++;
    }
}

console.log(partNum);