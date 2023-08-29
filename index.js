/*
 * Created by Younes Megaache on 29/08/2023, 7:21 am
 * Copyright (c) 2023.
 */

const webGradients = require("./webgradients.com.json")
const fs = require('fs')

var kotlin = `
import androidx.compose.ui.graphics.Color
`

for (item of webGradients) {
    const colors = item.gradient.map(v => `${(v.pos / 100).toFixed(2)}f to Color(${v.color.toUpperCase().replace("#", "0xFF")})`).join(",")

    kotlin += `
val ${item.name.replaceAll(" ", "")} = arrayOf(${colors})
`

}

fs.writeFileSync("gradient.kt", kotlin, "utf-8")

console.log("\nGradient.kt generated successfully\n")