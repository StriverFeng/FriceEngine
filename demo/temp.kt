import org.frice.game.Game
import org.frice.game.event.OnClickEvent
import org.frice.game.event.OnMouseEvent
import org.frice.game.event.OnWindowEvent
import org.frice.game.obj.ImageObject
import org.frice.game.resource.FileImageResource
import org.frice.game.utils.time.FTimer
import java.awt.Rectangle
import java.io.File
import java.util.*

/**
 * Created by ice1000 on 2016/8/13.
 * @author ice1000
 * @since v0.1
 */
class Demo3 : Game() {
	val dickTimer = FTimer(1000)

	var fuck = 0.0

	val objList = ArrayList<ImageObject>()
	var mode = 0
	override fun onInit() {
		bounds = Rectangle(100, 100, 640, 480)
		title = "Demo3 of Frice"
		refreshPerSecond = 100
//		back = ColorResource.BLUE
	}

	override fun onRefresh() {
		if (dickTimer.ended()) {
			val texture = FileImageResource("tres" + File.separator + "display.png")
			val obj: ImageObject
			if (fuck > 300) mode = 1 else if (fuck < 1) mode = 0
			when (mode) {
				0 -> {
					obj = ImageObject(texture, fuck, fuck)
					objList.add(obj)
					addObject(obj)
					fuck += 100
				}
				1 -> {
					obj = objList[objList.size - 1]
					objList.remove(obj)
					removeObject(obj)
					fuck -= 100
				}
			}
//			FLog.v("objList.size = ${objList.size}")
		}
	}

	override fun onExit() {
		System.exit(0)
	}

	override fun onMouse(e: OnMouseEvent?) {
	}

	override fun onClick(e: OnClickEvent?) {
	}

	override fun onLoseFocus(e: OnWindowEvent?) {
		paused = true
	}

	override fun onFocus(e: OnWindowEvent?) {
		paused = false
	}

	companion object {
		@JvmStatic fun main(args: Array<String>) {
			Demo3()
		}
	}
}