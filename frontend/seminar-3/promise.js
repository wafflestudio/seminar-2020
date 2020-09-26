function sleep(ms) {
  return new Promise((resolve, reject) => setTimeout(resolve, ms));
}

const  process= async () =>  {
  console.log('안녕하세요!');
  await sleep(1000 * 2); // 1초쉬고
  console.log('반갑습니다!');
}

try {
  process();
} catch(e) {
  console.log(e)
}
