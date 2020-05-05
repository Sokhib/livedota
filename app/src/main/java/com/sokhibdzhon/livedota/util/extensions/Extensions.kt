package com.sokhibdzhon.livedota.util.extensions


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

fun Any?.runIfNull(block: () -> Unit) {
    if (this == null) block()
}