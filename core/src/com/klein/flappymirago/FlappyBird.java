package com.klein.flappymirago;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture obstaculoBaixo, obstaculoCima, imagemFundo;
	Texture passros[];
	float posicaoX = 0, altura, espaco, contador = 0.0f;

	@Override
	public void create() {
		batch = new SpriteBatch();
		obstaculoBaixo = new Texture("cano_baixo.png");
		obstaculoCima = new Texture("cano_topo.png");
		imagemFundo = new Texture("imagemfundo.png");

		posicaoX = Gdx.graphics.getWidth();
		altura = Gdx.graphics.getHeight() / 2;
		espaco = 750;
		
		passros = new Texture[6];
		for (int i = 0; i < passros.length; i++){
			passros[i] = new Texture("passaro" + String.valueOf(i+1)+".png");
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		posicaoX -= Gdx.graphics.getDeltaTime() * 500;
		if (posicaoX < -obstaculoBaixo.getWidth()){
			posicaoX = Gdx.graphics.getWidth();
		}

		contador += Gdx.graphics.getDeltaTime() * 10;
		if(contador > 6){ contador = 0; }


		batch.begin();
		batch.draw(imagemFundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(obstaculoBaixo, posicaoX, altura - espaco / 2 - obstaculoBaixo.getHeight());
		batch.draw(obstaculoCima, posicaoX, altura + espaco / 2);

		batch.draw(passros[(int) contador], 50, Gdx.graphics.getHeight() / 2);
		batch.end();
    }
}