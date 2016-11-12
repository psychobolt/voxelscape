/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opencl;

import org.lwjgl.util.generator.Check;
import org.lwjgl.util.generator.NativeType;
import org.lwjgl.util.generator.OutParameter;
import org.lwjgl.util.generator.PointerWrapper;
import org.lwjgl.util.generator.opencl.cl_int;

import java.nio.IntBuffer;

/** The core OpenCL 1.2 OpenGL interrop functionality. */
public interface CL12GL {

	/* cl_gl_object_type */
	int CL_GL_OBJECT_TEXTURE2D_ARRAY = 0x200E,
		CL_GL_OBJECT_TEXTURE1D       = 0x200F,
		CL_GL_OBJECT_TEXTURE1D_ARRAY = 0x2010,
		CL_GL_OBJECT_TEXTURE_BUFFER  = 0x2011;

	@Check(value = "errcode_ret", canBeNull = true)
	@PointerWrapper(value = "cl_mem", params = "context")
	CLMem clCreateFromGLTexture(@PointerWrapper("cl_context") CLContext context,
	                            @NativeType("cl_mem_flags") long flags,
	                            @NativeType("GLenum") int target,
	                            @NativeType("GLint") int miplevel,
	                            @NativeType("GLuint") int texture,
	                            @OutParameter @Check(value = "1", canBeNull = true) @cl_int IntBuffer errcode_ret);

}