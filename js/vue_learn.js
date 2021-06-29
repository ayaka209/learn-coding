// 来自Vue文档

// 维持一个执行副作用的栈
const runningEffects = []

const createEffect = fn => {
    // 将传来的 fn 包裹在一个副作用函数中
    const effect = () => {
        runningEffects.push(effect)
        fn()
        runningEffects.pop()
    }

    // 立即自动执行副作用
    effect()
}
createEffect(() => {
    let sum = 1 + 1;
    console.log(sum);
})
