package org.frice.game.obj.effects

import org.frice.game.obj.AbstractObject
import org.frice.game.obj.sub.ImageObject
import org.frice.game.platform.FriceImage
import org.frice.game.resource.graphics.ColorResource
import org.frice.game.resource.graphics.ParticleResource
import org.frice.game.resource.image.ImageResource
import org.frice.game.utils.graphics.shape.FRectangle

/**
 * Created by ice1000 on 2016/8/19.
 *
 * @author ice1000
 * @since v0.5
 */
class LineEffect
@JvmOverloads
constructor(
		var color: ColorResource = ColorResource.BLACK,
		override var x: Double,
		override var y: Double,
		var x2: Double,
		var y2: Double) : AbstractObject {

	override var rotate = 0.0
}

/**
 * Created by ice1000 on 2016/8/17.
 * @author ice1000
 * @since 0.3.2
 */
class ParticleEffect(
		private var resource: ParticleResource,
		override var x: Double,
		override var y: Double) : ImageObject(resource.getResource(), x, y) {
	override val image: FriceImage get() = resource.getResource()

	override val collideBox = FRectangle(x.toInt(), y.toInt())

	override val width: Double get() = resource.width.toDouble()
	override val height: Double get() = resource.height.toDouble()

	override fun getResource() = ImageResource(image)

	override fun scale(x: Double, y: Double) {
		resource.width = (resource.width * x / 1000.0).toInt()
		resource.height = (resource.height * y / 1000.0).toInt()
	}

	//	override fun isCollide(other: CollideBox): Boolean = false
}
